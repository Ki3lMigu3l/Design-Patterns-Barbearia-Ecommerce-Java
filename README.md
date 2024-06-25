# Sistema de Gerenciamento de Barbearia e E-commerce

Este projeto tem por finalidade explora o uso dos padrões de projeto Singleton, Strategy e Facade para implementar um sistema de gerenciamento de uma barbearia e um E-commerce com Spring.]

## Sistema de Gerenciamento de Barbearia

### Padrões de Projeto Utilizados
1. **Singleton**: Classe BarbershopManager é utilizada para gerenciar os serviços oferecidos pela barbearia, garantindo que apenas uma instância do gerenciador exista.
2. **Strategy**: Interface PaymentStrategy e suas implementações (CreditCardPayment, PixPayment, CashPayment) são utilizadas para processar diferentes métodos de pagamento.
3. **Facade**: Classe BarbershopFacade fornece uma interface simplificada para acessar as funcionalidades da barbearia, como adicionar serviços, exibir serviços disponíveis e realizar pagamentos.

```mermaid
classDiagram
    class BarbershopManager {
        - static instance: BarbershopManager
        - services: List<String>
        + getInstance(): BarbershopManager
        + addService(service: String): void
        + getServices(): List<String>
    }

    class PaymentStrategy {
        + pay(amount: double): void
    }

    class CreditCardPayment {
        + pay(amount: double): void
    }

    class PixPayment {
        + pay(amount: double): void
    }

    class CashPayment {
        + pay(amount: double): void
    }

    class BarbershopFacade {
        - manager: BarbershopManager
        + addService(service: String): void
        + showServices(): void
        + makePayment(amount: double, strategy: PaymentStrategy): void
    }

    BarbershopManager <-- BarbershopFacade
    BarbershopFacade *-- PaymentStrategy
    PaymentStrategy <|.. CreditCardPayment
    PaymentStrategy <|.. PixPayment
    PaymentStrategy <|.. CashPayment

```

<br><br>
## Sistema de E-commerce com Spring Framework

### Padrões de Projeto Utilizados
1. **Singleton**: Classe ProductCatalog é utilizada para gerenciar o catálogo de produtos do e-commerce, garantindo que apenas uma instância do catálogo exista e seja acessível globalmente.
2. **Strategy**: Interface PricingStrategy e suas implementações (DefaultPricingStrategy, QuantityDiscountPricingStrategy, PromotionalPricingStrategy) são utilizadas para calcular o preço dos pedidos de acordo com diferentes estratégias de precificação.
3. **Facade**: Classe OrderFacade fornece uma interface simplificada para realizar pedidos, calcular preços e acessar informações do catálogo de produtos.

```mermaid
classDiagram
    class Product {
        - id: Long
        - name: String
        - price: double
        + getId(): Long
        + getName(): String
        + getPrice(): double
    }

    class ProductCatalog {
        - static instance: ProductCatalog
        - products: List<Product>
        + getInstance(): ProductCatalog
        + addProduct(product: Product): void
        + removeProduct(product: Product): void
        + getProductById(id: Long): Product
        + getAllProducts(): List<Product>
    }

    class PricingStrategy {
        + calculatePrice(items: List<Product>): double
    }

    class DefaultPricingStrategy {
        + calculatePrice(items: List<Product>): double
    }

    class QuantityDiscountPricingStrategy {
        + calculatePrice(items: List<Product>): double
    }

    class PromotionalPricingStrategy {
        + calculatePrice(items: List<Product>): double
    }

    class OrderFacade {
        + placeOrder(products: List<Product>): double
    }

    class ProductController {
        + getAllProducts(): List<Product>
        + getProductById(id: Long): Product
    }

    ProductCatalog --> Product
    OrderFacade --> PricingStrategy
    ProductController --> ProductCatalog

```
