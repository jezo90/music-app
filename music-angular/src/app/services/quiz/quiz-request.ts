export class QuizRequest {
  constructor(
    public userId: number,
    public albumId: number | null,
    public artistId: number | null,
    public numberOfWords: number
  ) {
  }
}
