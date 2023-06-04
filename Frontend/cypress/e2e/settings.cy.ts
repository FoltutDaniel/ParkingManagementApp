import '../support/commands'
context('Settings', ()=> {
  before(() => {
    cy.register();
  })

  beforeEach(() => {
    cy.visit('/login');
    cy.login().wait(100);
    cy.getByDataCy('SETTINGS-BTN').click().wait(500);
  })

  after(() =>{
    cy.visit('/login');
    cy.login().wait(100);
    cy.deleteUser();
  })

  it('should change user email', () =>{
    cy.getByDataCy('CHANGE-EMAIL-BTN').click().wait(500);
    cy.getByDataCy('OLD-EMAIL-IP').type('newUser@mail.com').wait(500);
    cy.getByDataCy('NEW-EMAIL-IP').type('newUserChanged@mail.com').wait(500);
    cy.getByDataCy('PASSWORD-IP').type('newUserPass.10').wait(500);
    cy.getByDataCy('CONFIRM-BTN').click().wait(500);
  })

  it('should change user password', () =>{
    cy.getByDataCy('CHANGE-PASSWORD-BTN').click().wait(500);
    cy.getByDataCy('OLD-PASSWORD-IP').type('newUserPass.10').wait(500);
    cy.getByDataCy('NEW-PASSWORD-IP').type('userPass.10').wait(500);
    cy.getByDataCy('CONFIRM-BTN').click().wait(500);
  })
})
