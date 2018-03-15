import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserSettingService } from './user-setting.service';
import { EmailValidator } from '../../theme/validators/email.validator';

@Component({
  selector: 'xdr-user-setting',
  templateUrl: './user-setting.component.html',
  styleUrls: ['./user-setting.component.scss'],
})
export class UserSettingComponent implements OnInit {

  private userData: any;
  private isEditable: boolean = false;
  private isEditInfo: boolean = false;
  private isModifyPass: boolean = false;
  private firstName: string;
  private email: string;
  private isEmailInvalid: boolean = false;
  private password: string;
  private confirmPassword: string;
  private isShowUnMatch: boolean = false;
  private isUnSubmitable: boolean = true;
  private status: number = -1;

  @ViewChild('infoSuccess') private infoSuccessDiv: ElementRef;
  @ViewChild('infoError') private infoErrorDiv: ElementRef;
  @ViewChild('passSuccess') private passSuccessDiv: ElementRef;
  @ViewChild('passError') private passErrorDiv: ElementRef;

  constructor(private _userService: UserSettingService) {
  }

  ngOnInit() {
    this._userService.getAccount().then(data => {
      this.userData = data;
      this.firstName = this.userData.firstName;
      this.email = this.userData.email;
      // console.debug(this.userData.login);
    });
  }

  // 点击修改密码
  public modifyPass() {
    this.isEditable = true;
    this.isModifyPass = true;
  }

  // 点击编辑资料
  public editInfo() {
    this.isEditable = true;
    this.isEditInfo = true;
  }

  public infoSubmit() {
    this.status = -1;
    this._userService.editInfo(this.firstName, this.email).subscribe(() => {
      this._userService.getAccount().then(data => {
        this.userData = data;
        this.firstName = this.userData.firstName;
        this.email = this.userData.email;
      });
      this.showResult(this.infoSuccessDiv);
      this.isEditable = false;
      this.isEditInfo = false;
      this.status = 200;
    }, (response) => {
      if (response.status === 400) {
        this.status = 400;
        console.debug(this.status);
      }else {
        this.showResult(this.infoErrorDiv);
      }
    });
  }

  // 编辑资料重置
  public resetInfo() {
    this.status = -1;
    this.firstName = this.userData.firstName;
    this.email = this.userData.email;
    this.isEmailInvalid = false;
  }

  // 编辑资料取消
  public cancelInfo() {
    this.status = -1;
    this.isEditable = false;
    this.isEditInfo = false;
    this.isEmailInvalid = false;
    this.firstName = this.userData.firstName;
    this.email = this.userData.email;
  }

  // 修改密码重置
  public resetPass(myForm: NgForm) {
    myForm.reset();
  }

  // 修改密码取消
  public cancelPass(myForm: NgForm) {
    this.isEditable = false;
    this.isModifyPass = false;
    myForm.reset();
  }

  public testValid() {
    this.status = -1;
    const EMAIL_REGEXP = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!EMAIL_REGEXP.test(this.email)) {
      this.isEmailInvalid = true;
    }else {
      this.isEmailInvalid = false;
    }
  }

  public finishModifyPass() {
    if (this.password !== this.confirmPassword) {
      this.isShowUnMatch = true;
      this.isUnSubmitable = true;
    }else {
      this.isShowUnMatch = false;
      this.isUnSubmitable = false;
    }
  }

  public passSubmit() {
    this._userService.changePass(this.password).subscribe(() => {
      this.showResult(this.passSuccessDiv);
      this.isEditable = false;
      this.isModifyPass = false;
    }, (response) => {
      this.showResult(this.passErrorDiv);
    });
  }

  private showResult(div) {
    setTimeout(() => {
      div.nativeElement.style.display = 'block';
    }, 0);
    setTimeout(() => {
      div.nativeElement.style.display = 'none';
    }, 2000);
  }

}
