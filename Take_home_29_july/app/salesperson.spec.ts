import { SalesPerson } from './salesperson';

describe('Salesperson', () => {
  it('should create an instance', () => {
    expect(new SalesPerson("","","",0,"")).toBeTruthy();
  });
});
