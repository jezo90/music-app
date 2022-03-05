export class QuizSave {
  constructor(
    public userId: number,
    public firstTrackId: number,
    public secondTrackId: number,
    public thirdTrackId: number,
    public words: string,
    public correctAnswerId: number,
    public chosenAnswerId: number
  ) {
  }
}
