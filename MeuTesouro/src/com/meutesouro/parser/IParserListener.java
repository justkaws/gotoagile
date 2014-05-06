package com.meutesouro.parser;

import java.util.List;

import com.meutesouro.entity.MoneyTitle;

public interface IParserListener {
	public void infoReceived(List<MoneyTitle> moneyTitlesList);
}
