
###Sorteo de Equipos para Liga Profesional
Este proyecto es una aplicación en Java que organiza de manera aleatoria los partidos de una liga profesional de fútbol en diferentes etapas: octavos de final, cuartos de final, semifinales y final. El programa permite ingresar equipos, emparejarlos de forma aleatoria, determinar un ganador en cada partido y avanzar automáticamente hasta que quede un único campeón.

- Ingreso de Equipos
- Validación de Equipos
- Sorteo Aleatorio
- Determinación de Ganadores 
- Progresión del Torneo 
####Clases Principales
**- SorteoEquipos:** Clase principal que inicia la aplicación, permite al usuario seleccionar la etapa del torneo e inicia el sorteo.
**- Etapa:** Clase abstracta que define los métodos base para organizar el torneo.
####Subclases de Etapa:
- **Octavos:** Maneja la etapa de octavos de final (16 equipos).
- **Cuartos: **Maneja la etapa de cuartos de final (8 equipos).
- **Semifinales: **Maneja la etapa de semifinales (4 equipos).
- **Finales:** Maneja la etapa final (2 equipos).
