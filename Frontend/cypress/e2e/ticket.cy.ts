import '../support/commands'

context('Subscription tests', () => {
  before(() => {
    cy.register();
  })

  beforeEach(() =>{
    cy.visit('/login');
    cy.login();
    cy.getByDataCy('TICKET-BTN').click().wait(500);
  })

  afterEach(() =>{
    cy.logout();
  })

  after(() => {
    cy.visit('/login');
    cy.login();
    cy.deleteUser().wait(500);
    cy.logout();
  })

  it('should purchase a new subscription', () => {
    cy.addCar();
    cy.getByDataCy('TICKET-BTN').click().wait(500);
    cy.getByDataCy('SUB-CAR-SL').select('BH08CPP').wait(500);
    cy.getByDataCy('CONFIRM-BTN').click().wait(500);
    cy.getByDataCy('AVAILABLE-TICKET').should('exist');
  })

  it('should cancel an existing ticket', () =>{
    cy.getByDataCy('MANAGE-ACCOUNT-BTN').click().wait(500);
    cy.getByDataCy('CANCEL-SUB-BTN').click().wait(500);
    cy.getByDataCy('LICENSE-PLATE-SL').select('BH08CPP').wait(500);
    cy.getByDataCy('PASSWORD-IP').type('newUserPass.10').wait(500);
    cy.getByDataCy('CONFIRM-BTN').click().wait(500);
    cy.getByDataCy('NO-AVAILABLE-SUB').should('exist');
    cy.removeCar();
    cy.getByDataCy('BH08CPP').should('not.exist');
  })
})
