import {Artist} from "./artist";


describe('Artist', () => {
  it('should create an instance', () => {
    expect(new Artist(0,'','','', Date.now() )).toBeTruthy();
  });
});
