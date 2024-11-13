# Threat Modeling Activity Description

<table style="width:100%; 1px solid black;">
<tr>
    <th colspan="2">Objective</th>
</tr>
<tr>
    <td style="vertical-align:top" colspan="2">Identify potential threats to implement effective preventive measures</td>
</tr>
<tr>
    <th>Triggers</th>
    <th>Recommended participants</th>
</tr>
<tr>
    <td style="vertical-align:top">
        <ul>
            <li>New project</li>
            <li>Major changes</li>
            <li>Changes to security features</li>
            <li>Changes in threat landscape</li>
            <li>Every three to six months</li>
        </ul>
    </td>
    <td style="vertical-align:top">At least one person who knows the service well on a technical level, e.g. a tech lead or developer. 
    Inviting an individual who knows how to think about threat scenarios is valuable, but not a must.<br><br>
    A minimum of two people is recommended. 
    Limit the number of participants to ensure focused discussions.</td>
</tr>
<tr>
    <th>Input</th>
    <th>Consumable output</th>
</tr>
<tr>
    <td style="vertical-align:top">
        <ul>
            <li>System and data knowledge (e.g. technical architecture, data-flow diagram)</li>
            <li>Previous threat models</li>
        </ul>
    </td>
    <td style="vertical-align:top">Documented threat scenarios along with proposed mitigation strategies, which can be useful for risk analysis. Also, a data dictionary which is useful for the privacy team.</td>
</tr>
</table>

## Introduction
This threat modeling activity is based on Mozilla's Rapid Risk Assessment framework. 
This activity enhances product quality and contribute to developing sufficiently secure services. 

This activity is designed to be completed in approximately 30-60 minutes (instead of hours!).

<table>
<td style="vertical-align:top">The <b>purpose</b> is to implement secure enough systems from the get-go, as well as reduce time spent on rework.</td>

<td style="vertical-align:top">The <b>scope</b> is the service itself, like the infrastructure configuration code, processes or the team owning the service.</td>
</table>

> [!NOTE]
> This activity will take longer than the expected amount of 30-60 minutes the first time(s). It is normal to take a couple of rounds until being used to the way of thinking about threat scenarios. 

> [!TIP]
> We recommend creating the data-flow diagram beforehand. Do not create it during the activity.

<table style="width:100%">
<tr>
    <th>What to focus on</th>
    <th>What not to focus on</th>
</tr>
<tr>
    <td style="vertical-align:top">
        <ul>
            <li>Assets that are important to protect, and whether there are any weak spots in assets, such as data, your team, processes, code and configurations</li>
            <li>Be realistic; focus on threats that are plausible and relevant to your context</li>
            <li>Recording threat scenarios</li>
        </ul>
    </td>
    <td style="vertical-align:top">
    Avoid discussing solutions during this activity; instead, focus on identifying for later resolution.
    </td>
</tr>
</table>

## Definitions
| Term | Definition |
|-|-|
| **Threat scenario** | Any event that could potentially harm the business, including data breaches or natural disasters. E.g., GDPR compliance requirements, poorly implemented authorization, or incorrectly configured settings. |
| **Driver** | The reason why a particular scenario is considered important or concerning, like new regulations or recent incidents. E.g., the new Cyber Resilience Act, the log4j-incident, or lack of knowledge. |
| **Threat** | Anything that has the potential to cause harm, including people (like attackers) and events (like natural disasters) |
| **Asset** | Any valuable resource that needs protection, including data, systems, employees, and intellectual property |

## Threats - who are likely to attack?
In our organization, attackers are likely to include individuals with moderate hacking skills, such as script kiddies and hacktivists. State-sponsored hackers are deemed less likely to pose a threat. Read more in [the threat assessment]().

## Related documents
Internal documents:
- Secure development standard, the development guide focusing on secure development
- Data classification policy, a guide on how to classify data
- Threat assessment, an assessment of what or who can harm the organization
- The organization's base threat scenarios

External sources of requirements that might be helpful:
- OWASP Application Security Verification Standard (ASVS)
- OWASP Mobile Application Security Verification Standard (MASVS)
- BSOMM

## Feedback
We always want to improve! For suggestions to improve this activity, please contact the AppSec department or your team's Security Champion. 
