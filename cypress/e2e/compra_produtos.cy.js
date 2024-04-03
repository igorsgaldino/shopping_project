describe('Compra de Produtos', () => {
  it.only('Caso 1 - Usuário realiza compra com sucesso', () => {
    //Usuário realiza login com sucesso
    cy.visit('https://www.saucedemo.com/');
    cy.get('[data-test="username"]').type('standard_user');
    cy.get('[data-test="password"]').type('secret_sauce');
    cy.get('[data-test="login-button"]').click();
    //Usuário seleciona produtos no carrinho
    cy.get('[data-test="add-to-cart-sauce-labs-backpack"]').click();
    cy.get('[data-test="add-to-cart-sauce-labs-fleece-jacket"]').click();
    cy.get('[data-test="shopping-cart-link"]').click();
    cy.get('[data-test="shopping-cart-badge"]').should('be.visible').and('contain', '2');  //Verifica quantidade itens
    //Usuário clica no botão "Checkout" para prosseguir com a compra
    cy.get('[data-test="checkout"]').click();
    //Usuário preenche os campos para prosseguir com a compra
    cy.get('[data-test="firstName"]').type('Igor');
    cy.get('[data-test="lastName"]').type('Galdino');
    cy.get('[data-test="postalCode"]').type('11608-545')
    //Usuário clica no botão "Continue"
    cy.get('[data-test="continue"]').click();
    //Verifica Informação do Pagamento
    cy.get('[data-test="payment-info-label"]').should('be.visible').and('contain', 'Payment Information:');
    cy.get('[data-test="payment-info-value"]').should('be.visible').and('contain', 'SauceCard #31337');
    //Verifica Informação de Envio
    cy.get('[data-test="shipping-info-label"]').should('be.visible').and('contain', 'Shipping Information:');
    cy.get('[data-test="shipping-info-value"]').should('be.visible').and('contain', 'Free Pony Express Delivery!');
    //Verifica o Valor Total e Taxa
    cy.get('[data-test="total-info-label"]').should('be.visible').and('contain', 'Price Total');
    cy.get('[data-test="subtotal-label"]').should('be.visible').and('contain', 'Item total: $79.98');
    cy.get('[data-test="tax-label"]').should('be.visible').and('contain', 'Tax: $6.40');
    cy.get('[data-test="total-label"]').should('be.visible').and('contain', 'Total: $86.38');
    //Usuário finaliza compra
    cy.get('[data-test="finish"]').click();
    //Verifica mensagens de compra realizada com sucesso
    cy.get('[data-test="pony-express"]').should('be.visible');
    cy.get('[data-test="complete-header"]').should('be.visible').and('contain', 'Thank you for your order!');
    cy.get('[data-test="complete-text"]').should('be.visible').and('contain', 'Your order has been dispatched, and will arrive just as fast as the pony can get there!');
    //Usuário clica no botão para retornar para a "Home"
    cy.get('[data-test="back-to-products"]').click();
    //Usuário realiza logout do sistema
    cy.get('#react-burger-menu-btn').click();
    cy.get('[data-test="logout-sidebar-link"]').click();
    })
  })
