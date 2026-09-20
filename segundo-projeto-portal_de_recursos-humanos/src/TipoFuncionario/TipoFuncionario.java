package TipoFuncionario;

public enum TipoFuncionario {
    GERENTE("Gerente", false, 0),
    COORDENADOR("Coordenador", true, 5),
    ANALISTA("Analista", true, 3),
    ASSISTENTE("Assistente", true, 3),
    ESTAGIARIO("Estagiário", false, 0);

    private final String descricao;
    private final boolean batePonto;
    private final int maxHorasExtras;

    TipoFuncionario(String descricao, boolean batePonto, int maxHorasExtras) {
        this.descricao = descricao;
        this.batePonto = batePonto;
        this.maxHorasExtras = maxHorasExtras;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isBatePonto() {
        return batePonto;
    }

    public int getMaxHorasExtras() {
        return maxHorasExtras;
    }
}
