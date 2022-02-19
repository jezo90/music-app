import { QuizRequest } from './quiz-request';

describe('QuizRequest', () => {
  it('should create an instance', () => {
    expect(new QuizRequest(0,0,0,0)).toBeTruthy();
  });
});
