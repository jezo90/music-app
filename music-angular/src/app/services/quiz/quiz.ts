export class Quiz {
  constructor(
    public userId: number,
    public quizId: number,
    public firstTrackTitle: string,
    public firstTrackId: number,
    public secondTrackTitle: string,
    public secondTrackId: number,
    public thirdTrackTitle: string,
    public thirdTrackId: number,
    public words: string
  ) {
  }

}
