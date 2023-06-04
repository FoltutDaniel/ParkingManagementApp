import '../support/commands'

context('Manage account tests', () =>{

  before(() => {
    cy.register();
  })

  beforeEach(() =>{
    cy.visit('/login');
    cy.login();
  })

  afterEach(() =>{
    cy.logout();
  })

  it('should add a new car to your account', ()=>{
    cy.addCar();
  })

  it('should remove a car from your account', () => {
    cy.removeCar();
    cy.deleteUser();
  })

})
