import { table } from './table.js';

//let data = [{ id: 1, name: 'US', authors: [{ id: 1, name: 'Engineering', posts: [{ id: 1, name: 'Joan' }, { id: 7, name: 'Scott' }, { id: 8, name: 'Sue' }, { id: 9, name: 'Stephanie' }, { id: 10, name: 'Jennifer' }] }, { id: 3, name: 'CA19', posts: [{ id: 6, name: 'Frank' }, { id: 11, name: 'Marcus' }] }] }, { id: 2, name: 'UK', authors: [{ id: 2, name: 'CA13', posts: [{ id: 2, name: 'Sarah' }, { id: 3, name: 'John' }, { id: 4, name: 'Roberts' }, { id: 5, name: 'Peter' }] }] }];


rootDiv.innerHTML = table(dataEl, 'EclipseLink')  
    + table(dataJdbc, 'Jdbc')  
     + table(dataHib, 'Hibernate');
