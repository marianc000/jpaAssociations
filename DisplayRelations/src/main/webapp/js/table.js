function div(val, className) {
    return `<div${className ? ' class="' + className +'"': ''}>${val}</div>`
}

export function table(data,className) {
    return div(div(['Country', 'Author', 'Title'].map(v => div(v)).join(''), 'row header') +

        data.flatMap((c, ci) =>
            c.authors.flatMap((a, ai) =>
                a.posts.map((p,pi) => div(div(c.name, 'country a'+ai+' p'+pi) + div(a.name, 'author a'+ai+' p'+pi) + div(p.name,'post a'+ai+' p'+pi), 'row'))
            )
        ).join(''),'table '+className);
}
