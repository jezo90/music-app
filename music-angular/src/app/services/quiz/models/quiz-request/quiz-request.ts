export class QuizRequest {
  constructor(
    public albumId: number,
    public artistId: number,
    public numberOfWords: number
  ) {
  }
}
