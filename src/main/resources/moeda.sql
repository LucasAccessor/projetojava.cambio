CREATE TABLE cambio.moeda (
	`id_moeda` VARCHAR(40) NOT NULL,
    `tx_nome` VARCHAR(50) NOT NULL,
    `tx_simbolo` VARCHAR(5) NOT NULL,
    PRIMARY KEY `pk_moeda` (`id_moeda`)
);