import { UppercasePipe } from './uppercase.pipe';

describe('UppercasePipe', () => {
  it('create an instance', () => {
    const pipe = new UppercasePipe();
    expect(pipe).toBeTruthy();
  });
});
