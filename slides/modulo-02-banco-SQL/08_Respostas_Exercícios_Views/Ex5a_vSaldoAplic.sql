SELECT A.COD_APLICACAO, A.DESCRICAO, 
       ROUND(SUM(AC.NRO_COTAS * CO.VALOR_COTA),2) AS VLR_APLIC
FROM APLICACAO A
  JOIN APLIC_CONTA AC ON A.COD_APLICACAO = AC.COD_APLICACAO
  JOIN APLIC_COTA CO ON AC.COD_APLICACAO = CO.COD_APLICACAO
WHERE CO.DATA = (SELECT MAX(DATA)
                 FROM APLIC_COTA
                 WHERE COD_APLICACAO = CO.COD_APLICACAO)
GROUP BY A.COD_APLICACAO, A.DESCRICAO
ORDER BY A.COD_APLICACAO