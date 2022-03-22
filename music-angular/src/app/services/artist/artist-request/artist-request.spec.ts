import { ArtistRequest } from './artist-request';

describe('ArtistRequest', () => {
  it('should create an instance', () => {
    expect(new ArtistRequest('','','', new Date(),'')).toBeTruthy();
  });
});
