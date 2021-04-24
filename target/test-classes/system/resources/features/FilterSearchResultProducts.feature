Feature: Filter Search Result Products
    As a client of the Netshoes store
    I want to be able to filter the products searched 
    So that I can easilly find the product that I want

    Background: SETUP
    Given The client access the store's main page

    Scenario: Verify filter displayed on Eletronic scetion
    Given I click in "Eletrônicos" products
    When  I am in "Eletrônicos" section
    Then I should be able to see this filters below
        |Gênero         |
        |Tipo de Produto|
        |Tamanho        |
        |Marca          |
        |Preço          |
        |Cor            |
        |Avaliação      |
        |Promoções      |
        |Departamento   |
        |Desconto       |

    Scenario: Verify if the filter is applied 
    Given I click in "Eletrônicos" products
    And I am in "Eletrônicos" section
    When I select this filter below
        |Gênero          |Feminino    |
        |Tipo de Produto |Caixa de Som| 
        |Marca           |Apple       | 
    Then This filter below must be displayed as applied 
        |Feminino    |
        |Caixa de Som| 
        |Apple       |

    
    Scenario: Verify if the field Marca is in accordance with the field Tipo de Produto 
    Given I click in "Eletrônicos" products
    And  I am in "Eletrônicos" section
    When I select this filter below
        |Tipo de Produto |Notebook    | 
    Then The field Marca must display this attributes below 
        |AKG    |
        |Acer   | 
        |Apple  |
        |Asus   |
        |Compaq |
        |Dell   |
        |Fuseco |
        |HP     |
        |LENOVO |
        |Samsung|
