export class Quiz {
  constructor(
    public firstTrackId: number,
    public firstTrackTitle: string,
    public secondTrackId: number,
    public secondTrackTitle: string,
    public thirdTrackId: number,
    public thirdTrackTitle: string,
    public words: string,
    public correctAnswerId: number
  ) {
  }

}
