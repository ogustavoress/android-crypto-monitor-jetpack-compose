# Android Crypto Monitor - CP2
## Sobre o projeto
O **Android Crypto Monitor** é um aplicativo desenvolvido em **Kotlin** com o intuito de fornecer informações atualizadas sobre a cotação do Bitcoin. Utilizando uma API externa, o projeto demonstra como integrar interfaces e consumir dados remotamente.

Este aplicativo foi criado com o objetivo de  explorar recursos avançados de desenvolvimento no Android, incluindo integração com APIs via Retrofit e o uso de layouts dinâmicos para exibir dados em tempo real de maneira intuitiva.

## Arquivos do Projeto
### Layouts (.xml)
-   **activity_main.xml:** Estrutura geral da tela principal, integrando os elementos para visualização da cotação e interação com o botão de atualização.
-   **component_toolbar_main.xml:** Arquivo responsável pela configuração da Toolbar. 
-   **component_quote_information.xml:** Exibe os valores de cotação e a data da última atualização.
-   **component_button_refresh.xml:** Define o comportamento do botão que realiza a atualização dos dados.

#### **Código Kotlin (.kt)**

**Model:**
-   **TickerResponse.kt:** Estrutura de classes para mapear os dados retornados pela API. Inclui a classe `TickerResponse`, que encapsula o objeto principal `Ticker`, contendo detalhes como valor de compra e venda, data, e volume.
    

**Service:**
-   **MercadoBitcoinService.kt:** Define o contrato para acessar o endpoint da API que retorna os valores de cotação.
- **MercadoBitcoinServiceFactory.kt:** Configura o Retrofit, especificando URL base, conversores e a criação da instância do serviço.
    
**Principal:**
-   **MainActivity.kt:** Responsável por gerenciar as interações na interface principal e implementar lógica para chamadas de API e exibição de resultados.

## Principais Funcionalidades
-   **Configuração de Toolbar:** Utiliza elementos personalizados para aprimorar o design e facilitar a navegação.
    
-   **Chamada à API:** Realiza requisições GET para obter os dados atualizados do Bitcoin, com tratamento de erros.
    
-   **Interface Dinâmica:** Atualiza as informações na tela em tempo real, formatando dados de preço e data conforme padrões regionais.
### **Exemplo de Estrutura JSON**

A API retorna dados no seguinte formato:

json

```
{
  "ticker": {
    "high": "545000.00000000",
    "low": "535651.00000000",
    "vol": "17.92453792",
    "last": "540062.00000000",
    "buy": "539679.00000000",
    "sell": "540062.00000000",
    "open": "539598.00000000",
    "date": 1745789188,
    "pair": "BRLBTC"
  }
}

```
## Bibliotecas Utilizadas 
-   **AppCompat:** Oferece compatibilidade entre diferentes versões do Android, além de componentes aprimorados como Toolbar.
    
-   **Retrofit:** Biblioteca para realizar requisições HTTP e manipular APIs de forma simplificada.
    
-   **Coroutines:** Permite o processamento assíncrono, garantindo que a interface do usuário permaneça responsiva durante as chamadas à API.

## Estrura do Código Kotlin 
#### **TickerResponse.kt**

Define classes que representam os dados retornados pela API, com propriedades como preço máximo (`high`), mínimo (`low`), último valor (`last`), e data da consulta.
```
class TickerResponse(  
val ticker: Ticker  
)
```
```
class Ticker(  
    val high: String,  
    val low: String,  
    val vol: String,  
    val last: String,  
    val buy: String,  
    val sell: String,  
    val date: Long  
)
```
A API retorna um JSON com a chave `ticker` que contém os dados da cotação
```
{
  "ticker": {
    "high": "545000.00000000",
    "low": "535651.00000000",
    "vol": "17.92453792",
    "last": "540062.00000000",
    "buy": "539679.00000000",
    "sell": "540062.00000000",
    "open": "539598.00000000",
    "date": 1745789188,
    "pair": "BRLBTC"
  }
}
```
#### **MercadoBitcoinService.kt**

Interface que descreve a chamada GET ao endpoint da API do Mercado Bitcoin, retornando os dados em um formato encapsulado.
```
class MercadoBitcoinServiceFactory {  
    fun create(): MercadoBitcoinService {  
        val retrofit = Retrofit.Builder() // cria um builder para a instância do Retrofit 
            .baseUrl("https://www.mercadobitcoin.net/")  // define a URL base para as requisições. O endpoint que configuramos na interface MercadoBitcoinService (@GET("api/BTC/ticker/) será concatenado a essa URL base.
            .addConverterFactory(GsonConverterFactory.create())  // responsável por converter os dados da resposta da API em objetos Kotlin/Java.
            .build()  // cria a instância final do Retrofit após todas as configurações serem feitas no builder.
  
        return retrofit.create(MercadoBitcoinService::class.java)  // criação e retorno de uma instância de MercadoBitcoinService a partir do Retrofit configurado.
    }  
}
```
#### **MercadoBitcoinServiceFactory.kt**

Utiliza o Retrofit para configurar a URL base e conversores, criando uma instância funcional para consumo da API.

#### **MainActivity.kt**

Gerencia a tela principal, incluindo:

-   Configuração da Toolbar personalizada.
    
-   Lógica para atualizar os componentes de texto com os valores formatados da API.
    
-   Tratamento de erros e exibição de notificações ao usuário.
```
class MercadoBitcoinServiceFactory {  
    fun create(): MercadoBitcoinService {  
        val retrofit = Retrofit.Builder() // cria um builder para a instância do Retrofit 
            .baseUrl("https://www.mercadobitcoin.net/")  // define a URL base para as requisições. O endpoint que configuramos na interface MercadoBitcoinService (@GET("api/BTC/ticker/) será concatenado a essa URL base.
            .addConverterFactory(GsonConverterFactory.create())  // responsável por converter os dados da resposta da API em objetos Kotlin/Java.
            .build()  // cria a instância final do Retrofit após todas as configurações serem feitas no builder.
  
        return retrofit.create(MercadoBitcoinService::class.java)  // criação e retorno de uma instância de MercadoBitcoinService a partir do Retrofit configurado.
    }  
}
```

## Dependências do projeto

-   **AppCompat**: Essa biblioteca permite recursos mais modernos sejam usadas em versões mais antigas do android, assim como melhoras visuais melhorados como a toolbar, por exemplo.
    
-   **Retrofit**: permite que o Android se comunique com  _APIs externas_.
    
-   **Coroutines**: Os Coroutines facilitam o gerenciamento de  _tarefas assíncronas_  (que ocorrem em threads de fundo, sem travar o main thread). Utilizamos ele para que as chamadas da API (com o Retrofit) ocorram de forma assíncrona, o que significa que a interface do usuário pode continuar funcionando enquanto a requisição está sendo processada em segundo plano.
##  Evidencias do App 
-   Antes de clicar no botão "Atualizar"

[![image](https://private-user-images.githubusercontent.com/133826730/437997039-d4f9ed15-ff4a-46fd-a42c-d1d056e7fc56.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDU4NjkwNjIsIm5iZiI6MTc0NTg2ODc2MiwicGF0aCI6Ii8xMzM4MjY3MzAvNDM3OTk3MDM5LWQ0ZjllZDE1LWZmNGEtNDZmZC1hNDJjLWQxZDA1NmU3ZmM1Ni5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNDI4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDQyOFQxOTMyNDJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1mMmM5OTJkODQ0NzdiZGE4MTlkODUzMzRiZGZlZDFmMmNlY2IzYzVlNTJlMThlMmI1ZjJiYjgyMTNiZmY0ODVhJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.ayJlaBzanWT0QsCyoB9V6YYf5-GXs7xWfkQJhvE_vz4)](https://private-user-images.githubusercontent.com/133826730/437997039-d4f9ed15-ff4a-46fd-a42c-d1d056e7fc56.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDU4NjkwNjIsIm5iZiI6MTc0NTg2ODc2MiwicGF0aCI6Ii8xMzM4MjY3MzAvNDM3OTk3MDM5LWQ0ZjllZDE1LWZmNGEtNDZmZC1hNDJjLWQxZDA1NmU3ZmM1Ni5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNDI4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDQyOFQxOTMyNDJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1mMmM5OTJkODQ0NzdiZGE4MTlkODUzMzRiZGZlZDFmMmNlY2IzYzVlNTJlMThlMmI1ZjJiYjgyMTNiZmY0ODVhJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.ayJlaBzanWT0QsCyoB9V6YYf5-GXs7xWfkQJhvE_vz4)

-   Ao clicar no botão "Atualizar"

[![image](https://private-user-images.githubusercontent.com/133826730/437997070-46cc1ce3-af3e-4a9a-a72e-7c1280cdc03a.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDU4NjkwNjIsIm5iZiI6MTc0NTg2ODc2MiwicGF0aCI6Ii8xMzM4MjY3MzAvNDM3OTk3MDcwLTQ2Y2MxY2UzLWFmM2UtNGE5YS1hNzJlLTdjMTI4MGNkYzAzYS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNDI4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDQyOFQxOTMyNDJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1kYTJlNjRiZWI3ZjRhZjI4ZTkxYzY5ZDdlNzZiMDMxZDA2Y2Q1ODljZDNmYjY1OGM4N2RkODUwMGUzYmM3MDQ5JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.SB2K6yHE_D55ImrMSazDmJHeqcXptc-9crSK15lJpLE)](https://private-user-images.githubusercontent.com/133826730/437997070-46cc1ce3-af3e-4a9a-a72e-7c1280cdc03a.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDU4NjkwNjIsIm5iZiI6MTc0NTg2ODc2MiwicGF0aCI6Ii8xMzM4MjY3MzAvNDM3OTk3MDcwLTQ2Y2MxY2UzLWFmM2UtNGE5YS1hNzJlLTdjMTI4MGNkYzAzYS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNDI4JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDQyOFQxOTMyNDJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1kYTJlNjRiZWI3ZjRhZjI4ZTkxYzY5ZDdlNzZiMDMxZDA2Y2Q1ODljZDNmYjY1OGM4N2RkODUwMGUzYmM3MDQ5JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.SB2K6yHE_D55ImrMSazDmJHeqcXptc-9crSK15lJpLE)








