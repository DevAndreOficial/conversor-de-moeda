# 💱 Conversor de Moedas em Java

Seja bem-vindo ao **Conversor de Moedas**, um projeto simples e funcional em **Java** que permite converter entre diversas moedas internacionais utilizando taxas de câmbio em tempo real.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Gson](https://img.shields.io/badge/Gson-JSON-green?style=for-the-badge)
![API](https://img.shields.io/badge/API-Rates-00C8E0?style=for-the-badge)

---

## 📌 Funcionalidades

✅ Conversão de moedas usando taxas reais  
✅ Menu interativo via terminal  
✅ Registro de histórico de conversões em arquivo `.txt`  
✅ Suporte para múltiplas moedas (USD, ARS, BRL, COP, AOA)  
✅ Tratamento de exceções para entradas inválidas e problemas com a API

---

## 🧩 Tecnologias utilizadas

- **Java 17+**
- **Biblioteca Gson** (para tratar JSON)
- **API pública de taxas de câmbio**
- Manipulação de arquivos com `FileWriter`
- `Scanner` para entrada de dados via terminal

---

## ⚙️ Como executar

1. Clone o repositório:
```bash
git clone https://github.com/seuusuario/conversor-moedas-java.git
cd conversor-moedas-java
OBS: Certifique-se de instalar o Java e uma IDE na sua maquina para melhor experiença

📁 conversor-moedas-java/
├── Main.java
├── Conversor.java
├── ConsultarTaxaDisponiveis.java
├── GerarArquivo.java
├── Taxas.java
├── historico.txt (gerado automaticamente)
