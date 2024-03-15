describe('Logout spec', () => {
  it('Logout successfull', () => {
    cy.visit('/login');

    cy.intercept(
      {
        method: 'GET',
        url: '/login',
      },
      []
    );

    cy.url().should('include', '/login');
  });
});
