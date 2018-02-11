package GraphConsoleTest;

public class MappingScriptEntity {

	private int id;

	private String firstEdgeLabel;
	private String secondEdgeLabel;
	private String graphName;
	private String mappingScript;

	private boolean vertexLabelAndFieldKeyAndFieldValue = false;
	private boolean vertexId = false;
	private boolean direction = false;
	private boolean fields = false;
	private boolean edgeLabelFields = false;
	private boolean offset = false;
	private boolean limit = false;

	@Override
	public String toString() {
		final StringBuilder str = new StringBuilder();

		str.append("firstEdgeLabel: ");
		str.append(this.firstEdgeLabel);
		str.append("\n");
		str.append("secondEdgeLabel: ");
		str.append(this.secondEdgeLabel);
		str.append("\n");
		str.append("graphName: ");
		str.append(this.graphName);
		str.append("\n");
		str.append("mappingScript: ");
		str.append(this.mappingScript);
		str.append("\n");
		str.append("vertexLabelAndFieldKeyAndFieldValue: ");
		str.append(this.vertexLabelAndFieldKeyAndFieldValue);
		str.append("\n");
		str.append("vertexId: ");
		str.append(this.vertexId);
		str.append("\n");
		str.append("direction: ");
		str.append(this.direction);
		str.append("\n");
		str.append("fields: ");
		str.append(this.fields);
		str.append("\n");
		str.append("edgeLabelFields: ");
		str.append(this.edgeLabelFields);
		str.append("\n");
		str.append("offset: ");
		str.append(this.offset);
		str.append("\n");
		str.append("limit: ");
		str.append(this.limit);
		str.append("\n");
		return str.toString();
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getFirstEdgeLabel() {
		return this.firstEdgeLabel;
	}

	public void setFirstEdgeLabel(final String firstEdgeLabel) {
		this.firstEdgeLabel = firstEdgeLabel;
	}

	public String getSecondEdgeLabel() {
		return this.secondEdgeLabel;
	}

	public void setSecondEdgeLabel(final String secondEdgeLabel) {
		this.secondEdgeLabel = secondEdgeLabel;
	}

	public String getGraphName() {
		return this.graphName;
	}

	public void setGraphName(final String graphName) {
		this.graphName = graphName;
	}

	public boolean isVertexLabelAndFieldKeyAndFieldValue() {
		return this.vertexLabelAndFieldKeyAndFieldValue;
	}

	public void setVertexLabelAndFieldKeyAndFieldValue(final boolean vertexLabelAndFieldKeyAndFieldValue) {
		this.vertexLabelAndFieldKeyAndFieldValue = vertexLabelAndFieldKeyAndFieldValue;
	}

	public boolean isVertexId() {
		return this.vertexId;
	}

	public void setVertexId(final boolean vertexId) {
		this.vertexId = vertexId;
	}

	public boolean isDirection() {
		return this.direction;
	}

	public void setDirection(final boolean direction) {
		this.direction = direction;
	}

	public boolean isFields() {
		return this.fields;
	}

	public void setFields(final boolean fields) {
		this.fields = fields;
	}

	public boolean isEdgeLabelFields() {
		return this.edgeLabelFields;
	}

	public void setEdgeLabelFields(final boolean edgeLabelFields) {
		this.edgeLabelFields = edgeLabelFields;
	}

	public boolean isOffset() {
		return this.offset;
	}

	public void setOffset(final boolean offset) {
		this.offset = offset;
	}

	public boolean isLimit() {
		return this.limit;
	}

	public void setLimit(final boolean limit) {
		this.limit = limit;
	}

	public String getMappingScript() {
		return this.mappingScript;
	}

	public void setMappingScript(final String mappingScript) {
		this.mappingScript = mappingScript;
	}

}
