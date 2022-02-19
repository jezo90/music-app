import { Album } from './album';

describe('Album', () => {
  it('should create an instance', () => {
    expect(new Album(0,"",0,"","")).toBeTruthy();
  });
});
