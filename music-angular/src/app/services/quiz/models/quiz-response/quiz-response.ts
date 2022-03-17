export class QuizResponse {
  constructor(
    public userId: number,
    public firstTrackId: number,
    public firstTrackTitle: string,
    public secondTrackId: number,
    public secondTrackTitle: string,
    public thirdTrackId: number,
    public thirdTrackTitle: string,
    public words: string,
    public correctAnswerId: number,
    public userAnswerId: number
  ) {
  }
}
