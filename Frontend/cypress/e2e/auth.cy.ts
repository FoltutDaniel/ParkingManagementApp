import '../support/commands'
context('Auth', ()=> {
  beforeEach(() =>{
    cy.visit('/login');
  })

  it('should have title frontend', () =>{
    cy.title().should('equal', 'Parking App');
  });

  it('should not allow you to log in with invalid login data', ()=>{
    cy.getByDataCy('LOGIN_USERNAME').type('BadUser');
    cy.getByDataCy('LOGIN_PASSWORD').type('BadPassword');
    cy.getByDataCy('LOGIN_BUTTON').click().wait(500);
    cy.getByDataCy('LOGIN_ERROR_BANNER').should('have.text','Username or password is wrong.').wait(500);
    cy.url().should('contain', 'login');
  })

  it('should register a new account in the application', () =>{
    cy.getByDataCy('REGISTER_BUTTON').click().wait(500);
    cy.url().should('contain', 'register');
    cy.register();
    cy.login();
    cy.url().should('contain', 'home');
    cy.deleteUser().wait(500);
    cy.logout();
  });
});
