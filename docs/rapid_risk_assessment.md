| Service Owner(s)                | CTF-team |
|---------------------------------|----------|
| **Owner**                       |          |
| **Risk owner**                  |          |
| **Service Data Classification** |          |


## Service notes (2-5 minutes)
Hotellsystem for å holde styr på gjester og bookinger. Og tilgang til spaet. 

## Data Flow Diagram (DFD)
Veldig enkel illustrasjon av dataflyten i tjenesten.

## Data dictionary (5-10 minutes)
<details>
<summary>Instructions</summary>

1. List the data types that is both **processed** and **stored**. Any data you touch or see is to be considered. Grouping similar data is fine to be effective. These are the data that needs to be secured.
2. Set the _Service Data Classification_ value at the top of this document to the bulk or the most important data type classification. As a rule of thumb, data that is not externally exposed **and** stored with appropriate security controls does not qualify to the Service Data Classification, e.g. secrets stored in Azure Key Vault.

Data classification types (see your projects definition - every organization has their own definition): \
`PUBLIC` `INTERNAL` `CONFIDENTIAL` `STRICTLY CONFIDENTIAL`

</details>

| Data name/type | Classification | Comments |
|----------------|----------------|----------|
| Guest data     | `STRICTLY CONFIDENTIAL` | Personal data |
| Bank information | `STRICTLY CONFIDENTIAL` |          |
| Employee data  | `INTERNAL`     |          |
| Access token   | `STRICTLY CONFIDENTIAL` | Stored in Azure Key Vault |


## Threat/risk scenarios and preventive measures (10-20 min)
<details><summary>Instructions</summary>

Find appropriate scenarios for your system affecting **confidentiality, integrity and availability**. 

1. (10-15 minutes) Create risk scenarios by filling the **Scenario, Risk driver and Assessment** columns
2. Create issues and add them to the **Preventive measures** columns. Remember to prioritize them!

</details>

| Scenario | Risk driver (årsak) | Assessment - What may happen if we don't implement the controls? | Preventive measures (issues) |
| ------ | ------ | ------ | ------ | 
|  |  |  | 
|  |  |  | 
|  |  |  | 
|  |  |  | 


## Wrapping up!
* Make sure you filled the _Service Data Classification_ at the top of this document
* Remember to prioritize the Jira issues
* If deemed needed, setup another meeting for another RRA, threat modelling or vulnerability assessment
