export class User {
  constructor(
    public account: string,
      public name: string,
      public email: string,
      public password1: string,
      public password2: string) {
  }
}

export class UserInfo {
  constructor(public login: string, public firstName: string, public lastName: string,
  public email: string, public activated: boolean, public imageUrl: string, public langKey: string,
  public createdBy: string, public createdDate: string, public lastModifiedBy: string,
              public lastModifiedDate: string, public authorities: any) {}
}
