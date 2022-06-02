CREATE TABLE cambio.moeda (
	`id_moeda` VARCHAR(40) NOT NULL,
    `tx_nome` VARCHAR(50) NOT NULL,
    `tx_simbolo` VARCHAR(5) NOT NULL,
    PRIMARY KEY `pk_moeda` (`id_moeda`)
);

CREATE TABLE cambio.cotacao (
    id_cotacao VARCHAR(64) NOT NULL,
    id_moeda VARCHAR(64) NOT NULL,
    dt_data DATE NOT NULL,	
    vr_valor DECIMAL(14,4)  NOT NULL,
    PRIMARY KEY pk_cotacao (id_cotacao)
);