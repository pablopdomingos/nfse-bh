package com.pablodomingos.classes;

import com.pablodomingos.classes.rps.builders.*;
import com.pablodomingos.classes.rps.enums.*;

public class FabricaDeBuildersFake {

  public static TomadorBuilder getTomadorBuilder() {
    return new TomadorBuilder("85386860000168")
      .comNome("Nome Tomador")
      .comLogradouro("Logradouro")
      .comNumeroEndereco("1234")
      .comComplemento("Complemento")
      .comBairro("Bairro")
      .comCep("00000000")
      .comCodigoMunicipio("3118601")
      .comUf("MG")
      .comTelefone("00000000000")
      .comEmail("email@gmail.com");
  }

  public static PrestadorBuilder getRpsPrestadorBuilder() {
    return new PrestadorBuilder("85386860000168");
//        .comInscricaoMunicipal("123498");
  }
  
  public static IntermediarioBuilder getIntermediarioBuilder(){
    return new IntermediarioBuilder("12345678901230", "Nome Intermediario")
        .comInscricaoMunicipal("000000000000000");
  }

  public static ValoresBuilder getValoresBuilder(){
      return new ValoresBuilder(100.00)
//          .comValorPis(2.00)
//          .comValorCofins(3.00)
//          .comValorInss(4.00)
//          .comValorIr(5.00)
//          .comValorCsll(6.00)
//          .comValorDeducoes(7.00)
//          .comDescontoCondicionado(8.00)
//          .comDescontoIncondicionado(9.00)
//          .comOutrasRetencoes(10.00)
          .comIssRetido(false);
  }

  public static ServicoBuilder getServicoBuilder() {
    return new ServicoBuilder(getValoresBuilder(), "0101")
      .comCodigoMunicipio(4204608)
      .comMunicipioIncidencia(4204608)
      .comCodigoTributacaoMunicipio("110200188")
      .comDiscriminacao("Prog.")
      .comExigibilidadeISS(ExigibilidadeIss.EXIGIVEL);
  }

  public static RpsInfoBuilder getRpsInfoBuilder(){
    return new RpsInfoBuilder("1")
        .comId("1")
        .comSerie("A")
//        .comNaturezaOperacao(NaturezaOperacao.TRIBUTACAO_MUNICIPIO)
        .optanteSimplesNacional(true)
        .comPrestador(getRpsPrestadorBuilder())
        .comRegimeEspecialTributacao(RegimeEspecialTributacao.ME_EPP_SIMPLES_NACIONAL)
        .comServico(getServicoBuilder())
        .comStatus(RpsStatus.NORMAL)
        .comTomador(getTomadorBuilder());
  }

  public static LoteRpsBuilder getLoteRpsBuilder(){
    return new LoteRpsBuilder("366")
        .comId("rps1")
        .comDocumento("45111111111100")
        .comInscricaoMunicipal("123498")
        .comVersao(LoteRpsVersao.V1_00)
        .addRps(getRpsInfoBuilder());
  }

  public static PedidoCancelamentoInfBuilder getPedidoCancelamentoInfBuilder(){
    return new PedidoCancelamentoInfBuilder()
        .comId("1")
        .comCodigoCancelamento(CodigoCancelamento.ERRO_NA_EMISSAO)
        .comCnpj("45111111111100")
        .comInscricaoMunicipal("123498")
        .comCodigoMunicipioIbge("4204608")
        .comNumero("58");
  }
}