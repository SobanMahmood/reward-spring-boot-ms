import { useTable } from 'react-table';
//TODO: In-progress
const columns = React.useMemo(() => [
    {  
        Header: 'ID',  
        accessor: 'customer_id'  
    },
    {  
        Header: 'First Name',  
        accessor: 'first_name'  
    },
    {  
        Header: 'Last Name',  
        accessor: 'lasst_name'  
    }
],
[]);


const {getTableProps, getTableBodyProps, headerGroups, rows, prepareRow} = useTable({columns, customers});
const Customer =({customers}) => {
    return(
        <div>
            <table {...getTableProps()}>
                <thead>
                    {headerGroups.map((headerGroup) => (
                        <tr {...headerGroup.getHeaderGroupProps()}>
                            {headerGroup.headers.map((column) => (
                                <th {...column.getHeaderGroupProps()}>
                                    {column.render("Header")}
                                </th>
                            ))}
                        </tr>
                    ))}
                </thead>
                <tbody {...getTableBodyProps()}>
                    {rows.map((row) => {
                        prepareRow(row)
                        return (
                            <tr {...row.getRowProps()}>
                                {row.cells.map((cell) => (
                                    <td {...cell.getCellProps()}> {cell.render("Cell")}</td>
                                ))}
                            </tr>
                        )
                    })}

                </tbody>


            </table>

        </div>
    )
}

export default Customer