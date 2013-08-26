create database Sigmav;

use Sigmav;

select * from Veiculo;

select * from Peca;

select * from Fornecedor;

select * from Contato;

SELECT COUNT(*) FROM Peca;

select * from Fornecedor as t1 inner join Contato as t2 on t1.contato_id = t2.id where t1.nome like '%te%';