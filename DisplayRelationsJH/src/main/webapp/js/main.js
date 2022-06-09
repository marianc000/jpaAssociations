import { table } from './table.js';

rootDiv.innerHTML = table(dataEl, 'EclipseLink')  
    + table(dataJdbc, 'Jdbc') 
     + table(dataHib, 'Hibernate');
