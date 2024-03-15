describe('Register spec', () => {
  it('Register successfull', () => {
    cy.visit('/register');

    cy.intercept('POST', '/api/auth/register', {
      statusCode: 200,
    });

    cy.get('input[formControlName=firstName]').type('fatma');
    cy.get('input[formControlName=lastName]').type('zammel');
    cy.get('input[formControlName=email]').type(
      'fatma.benbelgacem2804@gmail.com'
    );
    cy.get('input[formControlName=password]').type(
      `${'Fatma123'}{enter}{enter}`
    );

    cy.url().should('include', '/login');
  });

  it('Register failed with an invalid password with one character and error message appeared', () => {
    cy.visit('/register');

    cy.intercept('POST', '/api/auth/register', {
      statusCode: 400,
    });

    cy.get('input[formControlName=firstName]').type('fatma');
    cy.get('input[formControlName=lastName]').type('zammel');
    cy.get('input[formControlName=email]').type(
      'fatma.benbelgacem2804@gmail.com'
    );
    cy.get('input[formControlName=password]').type(`${'x'}{enter}{enter}`);

    cy.get('form > span').contains('error');
  });
});
