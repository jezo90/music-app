export class Token {
  constructor(
    public token: string,
    public userId: number,
    public username: string,
    public email: string,
    public roles: string[]
  ) {}
}
