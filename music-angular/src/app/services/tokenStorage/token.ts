export class Token {
  constructor(
    public id: number,
    public token: string,
    public username: string,
    public roles: any
  ) {}
}
