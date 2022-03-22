export class ArtistRequest {
  constructor(
    public nickname: string,
    public firstName: string,
    public lastName: string,
    public birthDate: Date,
    public image: File | null
  ) {}
}
