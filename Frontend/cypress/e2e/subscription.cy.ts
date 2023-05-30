import '../support/commands'

context('Subscription tests', () => {
  before(() => {
    cy.register();
  })

  beforeEach(() =>{
    cy.visit('/login');
    cy.login();
    cy.getByDataCy('SUBSCRIPTION-BTN').click().wait(500);
  })

  afterEach(() =>{
    cy.logout();
  })

  after(() => {
    cy.visit('/login');
    cy.login();
    cy.deleteUser();
    cy.logout();
  })

  it('should purchase a new subscription', () => {
    cy.addCar();
    cy.getByDataCy('SUBSCRIPTION-BTN').click().wait(500);
    cy.getByDataCy('GET-SUB-2').click().wait(500);
    cy.getByDataCy('SUB-START-DATE-DP').type('2022-01-15')
    cy.getByDataCy('SUB-CAR-SL').select('BH08CPP').wait(500);
    cy.getByDataCy('CONFIRM-BTN').click().wait(500);
    cy.getByDataCy('AVAILABLE-SUB').should('exist');
  })

  it('should cancel an existing subscription', () => {
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
