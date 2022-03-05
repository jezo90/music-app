export class QuizSave {
  constructor(
    public username: string,
    public firstTrackId: number,
    public secondTrackId: number,
    public thirdTrackId: number,
    public words: string,
    public correctAnswerId: number,
    public chosenAnswerId: number
  ) {
  }
}
