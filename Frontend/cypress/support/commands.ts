export {};

declare global {
  namespace Cypress{
    interface Chainable{
      getByDataCy(selector: any): any;

      addCar(): any;

      login(): any;

      logout(): any;

      register(): any;

      deleteUser(): any;

      removeCar(): any;
    }
  }
}

Cypress.Commands.add('getByDataCy', (selector, ...args) =>{
  return cy.get(`[data-cy=${selector}]`, ...args);
})

Cypress.Commands.add('deleteUser', () => {
  cy.request({
    method: 'DELETE',
    url:'http://localhost:8080/user',
    headers: {
      Authorization: sessionStorage.getItem('token') + ''
    }
  }).then(response => {
    expect(response.status).to.eq(200);
  });
})

Cypress.Commands.add('login', () => {
  cy.getByDataCy('LOGIN_USERNAME').type('newUserTest').wait(500);
  cy.getByDataCy('LOGIN_PASSWORD').type('newUserPass.10').wait(500);
  cy.getByDataCy('LOGIN_BUTTON').click().wait(500);
})

Cypress.Commands.add('register', () => {
  cy.visit('/register');
  cy.getByDataCy('USERNAME').type('newUserTest');
  cy.getByDataCy('FIRST_NAME').type('new');
  cy.getByDataCy('LAST_NAME').type('Test');
  cy.getByDataCy('EMAIL').type('newUser@mail.com');
  cy.getByDataCy('PASSWORD').type('newUserPass.10');
  cy.getByDataCy('SIGN-UP-BTN').click().wait(500);
})

Cypress.Commands.add('logout', () => {
  cy.getByDataCy('LOGOUT-BTN').click();
  cy.url().should('contain', 'login');
})

Cypress.Commands.add('addCar', () => {
  cy.getByDataCy('MANAGE-ACCOUNT-BTN').click().wait(500);
  cy.getByDataCy('ADD-CAR-BTN').click().wait(500);
  cy.getByDataCy('NUMBER-PLATE-IN').type('BH08CPP').wait(500);
  cy.getByDataCy('BRAND-SL').select('Audi').wait(500);
  cy.getByDataCy('CONFIRM-BTN').click().wait(500);
  cy.getByDataCy('BH08CPP').should('exist');
})

Cypress.Commands.add('removeCar', ()=>{
  cy.getByDataCy('MANAGE-ACCOUNT-BTN').click().wait(500);
  cy.getByDataCy('REMOVE-CAR-BTN').click().wait(500);
  cy.getByDataCy('REMOVE-CAR-SL').select('BH08CPP').wait(500);
  cy.getByDataCy('CONFIRM-BTN').click().wait(500);
  cy.getByDataCy('BH08CPP').should('not.exist').wait(300);
})
