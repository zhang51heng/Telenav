package GraphConsoleTest;

public class MappingScriptParm {

	private String firstEdgeLabel;
	private String secondEdgeLabel;
	private String graphName;

	private String vertexLabelAndFieldKeyAndFieldValue;
	private String vertexId;
	private String direction;
	private String fields;
	private String edgeLabelFields;
	private String offset;
	private String limit;

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

	public String getVertexLabelAndFieldKeyAndFieldValue() {
		return this.vertexLabelAndFieldKeyAndFieldValue;
	}

	public void setVertexLabelAndFieldKeyAndFieldValue(final String vertexLabelAndFieldKeyAndFieldValue) {
		this.vertexLabelAndFieldKeyAndFieldValue = vertexLabelAndFieldKeyAndFieldValue;
	}

	public String getVertexId() {
		return this.vertexId;
	}

	public void setVertexId(final String vertexId) {
		this.vertexId = vertexId;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(final String direction) {
		this.direction = direction;
	}

	public String getFields() {
		return this.fields;
	}

	public void setFields(final String fields) {
		this.fields = fields;
	}

	public String getEdgeLabelFields() {
		return this.edgeLabelFields;
	}

	public void setEdgeLabelFields(final String edgeLabelFields) {
		this.edgeLabelFields = edgeLabelFields;
	}

	public String getOffset() {
		return this.offset;
	}

	public void setOffset(final String offset) {
		this.offset = offset;
	}

	public String getLimit() {
		return this.limit;
	}

	public void setLimit(final String limit) {
		this.limit = limit;
	}

}
