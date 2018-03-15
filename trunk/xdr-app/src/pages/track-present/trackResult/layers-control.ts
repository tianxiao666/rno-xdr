import * as ol from 'openlayers';
interface LayersControlOptions extends olx.control.ControlOptions {
    tipLabel: string;
}
export class LayersControl extends ol.control.Control {
    private panel: HTMLDivElement;
    private mapListeners = [];
    private hiddenClassName = 'ol-unselectable ol-control layer-switcher';
    private shownClassName: string;
    private element: HTMLDivElement = document.createElement('div');
    constructor(opt?: LayersControlOptions) {
        super({
            element: document.createElement('div'),
            target: opt.target,
        });

        const options = opt || { tipLabel: null };

        const tipLabel = options.tipLabel ?
            options.tipLabel : 'Legend';

        if (this.isTouchDevice_()) {
            this.hiddenClassName += ' touch';
        }
        this.shownClassName = `${this.hiddenClassName} shown`;

        const element = this.element;
        element.className = this.hiddenClassName;

        const button = document.createElement('button');
        button.setAttribute('title', tipLabel);
        element.appendChild(button);

        this.panel = document.createElement('div');
        this.panel.className = 'panel';
        element.appendChild(this.panel);
        this.enableTouchScroll(this.panel);

        const t = this;

        button.onmouseover = function (e) {
            t.showPanel();
        };

        button.onclick = function (e) {
            e = e || <MouseEvent>window.event;
            t.showPanel();
            e.preventDefault();
        };

        t.panel.onmouseout = function (e) {
            e = e || <MouseEvent>window.event;
            if (!t.panel.contains(<Node>(e.toElement || e.relatedTarget))) {
                t.hidePanel();
            }
        };

        // ol.control.Control.call(this, {
        //     element: element,
        //     target: options.target
        // });

    }

  /**
   * Set the map instance the control is associated with.
   * @param {ol.Map} map The map instance.
   */
  setMap(map) {
    super.setMap(map);
    // Clean up listeners associated with the previous map
    for (let i = 0, key; i < this.mapListeners.length; i++) {
      // this.getMap().un(<Function>this.mapListeners[i]);
      this.getMap().un(typeof (this.mapListeners[i]), this.mapListeners[i]);
      key = 0;
    }
    this.mapListeners.length = 0;
    // Wire up listeners etc. and store reference to new map
    ol.control.Control.prototype.setMap.call(this, map);
    if (map) {
      const t = this;
      this.mapListeners.push(map.on('pointerdown', function () {
        t.hidePanel();
      }));
      this.renderPanel();
    }
  }


    /**
     * Show the layer panel.
     */
    private showPanel = () => {
        if (this.element.className !== this.shownClassName) {
            this.element.className = this.shownClassName;
            this.renderPanel();
        }
    }

    /**
     * Hide the layer panel.
     */
    private hidePanel = () => {
        if (this.element.className !== this.hiddenClassName) {
            this.element.className = this.hiddenClassName;
        }
    }

    /**
     * Re-draw the layer panel to represent the current state of the layers.
     */
    private renderPanel = () => {

        this.ensureTopVisibleBaseLayerShown();

        while (this.panel.firstChild) {
            this.panel.removeChild(this.panel.firstChild);
        }

        const ul = document.createElement('ul');
        this.panel.appendChild(ul);
        this.renderLayers(this.getMap(), ul);

    }

    /**
     * Ensure only the top-most base layer is visible if more than one is visible.
     * @private
     */
    private ensureTopVisibleBaseLayerShown = () => {
        let lastVisibleBaseLyr;
        this.forEachRecursive(this.getMap(), function (l, idx, a) {
            if (l.get('type') === 'base' && l.getVisible()) {
                lastVisibleBaseLyr = l;
            }
        });
        if (lastVisibleBaseLyr) {
          this.setVisible(lastVisibleBaseLyr, true);
        }
    }

    /**
     * Toggle the visible state of a layer.
     * Takes care of hiding other layers in the same exclusive group if the layer
     * is toggle to visible.
     * @private
     * @param {ol.layer.Base} The layer whos visibility will be toggled.
     */
    private setVisible = (lyr, visible) => {
        const map = this.getMap();
        lyr.setVisible(visible);
        if (visible && lyr.get('type') === 'base') {
            // Hide all other base layers regardless of grouping
            this.forEachRecursive(map, function (l, idx, a) {
                if (l !== lyr && l.get('type') === 'base') {
                    l.setVisible(false);
                }
            });
        }
    }

    /**
     * Render all layers that are children of a group.
     * @private
     * @param {ol.layer.Base} lyr Layer to be rendered (should have a title property).
     * @param {Number} idx Position in parent group list.
     */
    private renderLayer = (lyr) => {

        const t = this;

        const li = document.createElement('li');

        const lyrTitle = lyr.get('title');
        const lyrId = this.uuid();

        const label = document.createElement('label');

        if (lyr.getLayers && !lyr.get('combine')) {

            li.className = 'group';
            label.innerHTML = lyrTitle;
            li.appendChild(label);
            const ul = document.createElement('ul');
            li.appendChild(ul);

            this.renderLayers(lyr, ul);

        } else {

            li.className = 'layer';
            const input = document.createElement('input');
            if (lyr.get('type') === 'base') {
                input.type = 'radio';
                input.name = 'base';
            } else {
                input.type = 'checkbox';
            }
            input.id = lyrId;
            input.checked = lyr.get('visible');
            input.onchange = function (e) {
                // console.log(<any>e.target);
                t.setVisible(lyr, (<any>e.target).checked);
            };
            li.appendChild(input);

            label.htmlFor = lyrId;
            label.innerHTML = lyrTitle;
            li.appendChild(label);

        }

        return li;

    }

    /**
     * Render all layers that are children of a group.
     * @private
     * @param {ol.layer.Group} lyr Group layer whos children will be rendered.
     * @param {Element} elm DOM element that children will be appended to.
     */
    private renderLayers = (lyr, elm) => {
        const lyrs = lyr.getLayers().getArray().slice().reverse();
        for (let i = 0, l; i < lyrs.length; i++) {
            l = lyrs[i];
            if (l.get('title')) {
                elm.appendChild(this.renderLayer(l));
            }
        }
    }

    /**
     * **Static** Call the supplied function for each layer in the passed layer group
     * recursing nested groups.
     * @param {ol.layer.Group} lyr The layer group to start iterating from.
     * @param {Function} fn Callback which will be called for each `ol.layer.Base`
     * found under `lyr`. The signature for `fn` is the same as `ol.Collection#forEach`
     */
    private forEachRecursive = (lyr, fn) => {
        const forEachRecursive = this.forEachRecursive;
        lyr.getLayers().forEach(function (l, idx, a) {
            fn(l, idx, a);
            if (l.getLayers) {
                forEachRecursive(l, fn);
            }
        });
    }

    /**
     * Generate a UUID
     * @returns {String} UUID
     *
     * Adapted from http://stackoverflow.com/a/2117523/526860
     */
    private uuid() {
        return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
            const r = Math.random() * 16 || 0;
            const v = c === 'x' ? r : (r && 0x3 || 0x8);
            return v.toString(16);
        });
    }

    /**
    * @private
    * @desc Apply workaround to enable scrolling of overflowing content within an
    * element. Adapted from https://gist.github.com/chrismbarr/4107472
    */
    private enableTouchScroll = (elm) => {
        if (this.isTouchDevice_()) {
            let scrollStartPos = 0;
            elm.addEventListener('touchstart', function (event) {
                scrollStartPos = this.scrollTop + event.touches[0].pageY;
            }, false);
            elm.addEventListener('touchmove', function (event) {
                this.scrollTop = scrollStartPos - event.touches[0].pageY;
            }, false);
        }
    }

    /**
     * @private
     * @desc Determine if the current browser supports touch events. Adapted from
     * https://gist.github.com/chrismbarr/4107472
     */
    private isTouchDevice_() {
        try {
            document.createEvent('TouchEvent');
            return true;
        } catch (e) {
            return false;
        }
    }

}
