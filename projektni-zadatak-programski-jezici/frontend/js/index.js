const table = document.getElementById('table')
const template = document.getElementById('employee')
const searchTitle = document.getElementById('search-title')

if(searchParam != null && searchParam !== ''){
    searchTitle.innerText = 'Employee search'
    fetchEmployees('/contact/' + searchParam)
} else {
    searchTitle.innerText = 'Employee list'
    fetchEmployees()
}

function fetchEmployees(url='') {
    fetch(`http://localhost:8000/api/employee${url}`)
        .then(rsp=>rsp.json())
        .then(data=> {
            if(data.length === 0 ){
                alert('Employee not found')
                fetchEmployees()
                return
            }
            data.forEach(employee => {
                const copy = template.content.cloneNode(true)
                copy.querySelector('.id').innerText = employee.id
                copy.querySelector('.name').innerText = employee.name
                copy.querySelector('.surname').innerText = employee.surname
                copy.querySelector('.contact').innerText = employee.contact
                copy.querySelector('.department').innerText = employee.department.name
                copy.querySelector('.createdAt').innerText = formatDate(employee.createdAt)
                copy.querySelector('.updatedAt').innerText = formatDate(employee.updatedAt)
                copy.querySelector('.edit').href = `./edit.html?id=${employee.id}`
                copy.querySelector('.remove').addEventListener('click',()=>{
                    if(confirm(`Do you want to remove employee ${employee.name} ${employee.surname} ?`)){
                        fetch(`http://localhost:8000/api/employee/${employee.id}`, {
                            method: 'DELETE',

                        })
                            .then(rsp=>{
                                if (rsp.status ===204) {
                                    window.location.href='./index.html'
                                    return
                                }

                                alert(`Employee removal failed(HTTP ${rsp.status}`)
                            })
                    }
                })
                table.appendChild(copy)
            })
        })
}
