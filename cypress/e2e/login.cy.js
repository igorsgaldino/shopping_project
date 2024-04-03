describe('Login', () => {
    it('Caso 1 - Usuário tenta acessar Home sem preencher os dados de Login', () => {
      cy.visit('https://www.saucedemo.com/');
      cy.get('[data-test="login-button"]').click();
      cy.get('[data-test="error"]').should('be.visible').and('have.text', 'Epic sadface: Username is required')
    })
    it('Caso 2 - Usuário tenta acessar Home preenchendo apenas o campo Username', () => {
      cy.visit('https://www.saucedemo.com/');
      cy.get('[data-test="username"]').type('nometeste');
      cy.get('[data-test="login-button"]').click();
      cy.get('[data-test="error"]').should('be.visible').and('have.text', 'Epic sadface: Password is required');
    })
    it('Caso 3 - Usuário tenta acessar Home preenchendo apenas o campo Password', () => {
      cy.visit('https://www.saucedemo.com/');
      cy.get('[data-test="password"]').type('senhadeteste');
      cy.get('[data-test="login-button"]').click();
      cy.get('[data-test="error"]').should('be.visible').and('have.text', 'Epic sadface: Username is required');
    })
    it('Caso 4 - Usuário tenta realizar login com dados inválidos', () => {
      cy.visit('https://www.saucedemo.com/');
      cy.get('[data-test="username"]').type('nometeste');
      cy.get('[data-test="password"]').type('senhadeteste');
      cy.get('[data-test="login-button"]').click();
      cy.get('[data-test="error"]').should('be.visible').and('have.text', 'Epic sadface: Username and password do not match any user in this service');
    })
    it('Caso 5 - Usuário realiza login com sucesso', () => {
      cy.visit('https://www.saucedemo.com/');
      cy.get('[data-test="username"]').type('standard_user');
      cy.get('[data-test="password"]').type('secret_sauce');
      cy.get('[data-test="login-button"]').click();
      
    })
})