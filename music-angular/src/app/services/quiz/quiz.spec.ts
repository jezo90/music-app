import { Quiz } from './quiz';

describe('Quiz', () => {
  it('should create an instance', () => {
    expect(new Quiz(0,0,'', 0, '', 0, '', 0, '')).toBeTruthy();
  });
});
