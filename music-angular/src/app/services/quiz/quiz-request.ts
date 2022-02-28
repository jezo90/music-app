export class QuizRequest {
  constructor(
    public albumId: number | null,
    public artistId: number | null,
    public numberOfWords: number
  ) {
  }
}
