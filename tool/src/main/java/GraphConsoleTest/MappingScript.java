package GraphConsoleTest;

import java.util.Arrays;
import java.util.List;

public class MappingScript {

	final String mappingScript = "gremlin=g_testzh.V(vertexId).direction1E(edgelabel1).direction1V().field1.direction2E(edgelabel2).direction2V().field2";

	final static String graphName = "testzh";
	final static String firstEdgeLabel = "relation";
	final static String secondEdgeLabel = "have";

	public String testFields(final MappingScriptParm msp, final MappingScriptEntity mse) throws Exception {

		String gremlinScript = mse.getMappingScript();
		System.out.println("Mysql Mapping script:");
		System.out.println(mse.toString());
		//parm is null error
		gremlinScript = gremlinScript.replaceAll("@graphName", msp.getGraphName());
		gremlinScript = gremlinScript.replaceAll("@edgelabel1", msp.getFirstEdgeLabel());
		gremlinScript = gremlinScript.replaceAll("@edgelabel2", msp.getSecondEdgeLabel());
		if (mse.isVertexId()) {
			gremlinScript = gremlinScript.replaceAll("@vertexId", msp.getVertexId());
		}
		//TODO if direction is null, set the default value out.
		if (mse.isDirection()) {
			final List<String> results = Arrays.asList(msp.getDirection().split(";"));
			for (final String result : results) {
				final List<String> direction = Arrays.asList(result.split("\\."));
				if (direction.get(0).equals(msp.getFirstEdgeLabel())) {
					gremlinScript = gremlinScript.replaceAll("@firstDir", direction.get(1));
					if ("in".equals(direction.get(1))) {
						gremlinScript = gremlinScript.replaceAll("@firstResult", "out");
					}
					else if ("out".equals(direction.get(1))) {
						gremlinScript = gremlinScript.replaceAll("@firstResult", "in");
					}
					else {
						gremlinScript = gremlinScript.replaceAll("@firstResult", "both");
					}
				}
				else if (direction.get(0).equals(msp.getSecondEdgeLabel())) {
					gremlinScript = gremlinScript.replaceAll("@secondDir", direction.get(1));
					if ("in".equals(direction.get(1))) {
						gremlinScript = gremlinScript.replaceAll("@secondResult", "out");
					}
					else if ("out".equals(direction.get(1))) {
						gremlinScript = gremlinScript.replaceAll("@secondResult", "in");
					}
					else {
						gremlinScript = gremlinScript.replaceAll("@secondResult", "both");
					}
				}
				else {
					throw new Exception();
				}
			}
		}

		if (mse.isEdgeLabelFields()) {
			final StringBuilder replacefield1 = new StringBuilder();
			final StringBuilder replacefield2 = new StringBuilder();
			final StringBuilder replacefield3 = new StringBuilder();
			replacefield3.append(".valueMap(true");
			final List<String> edgeLabelFieldResults = Arrays.asList(msp.getEdgeLabelFields().split(";"));
			for (final String edgeLabelFields : edgeLabelFieldResults) {
				final List<String> field = Arrays.asList(edgeLabelFields.split("\\."));
				if (field.size() == 1) {
					replacefield3.append(",'" + field.get(0) + "'");
				}
				else {
					if (field.get(0).equals(msp.getFirstEdgeLabel())) {
						replacefield1.append(".has('" + field.get(1) + "'," + field.get(2) + ")");
					}
					else if (field.get(0).equals(msp.getSecondEdgeLabel())) {
						replacefield2.append(".has('" + field.get(1) + "'," + field.get(2) + ")");

					}
					else {
						throw new Exception();
					}
				}
			}
			gremlinScript = gremlinScript.replaceAll(".@edgefield1", replacefield1.toString());
			gremlinScript = gremlinScript.replaceAll(".@edgefield2", replacefield2.toString());
			replacefield3.append(")");
			gremlinScript = gremlinScript.replaceAll(".@field3", replacefield3.toString());

		}
		return gremlinScript;
	}

	public static void main(final String[] args) throws Exception {
		// http post url:  graphapi/service/v1/circleofconnection/gremlin
		//post body: {
		//	"firstEdgeLabel":""
		//}

		final MappingScriptParm msp = new MappingScriptParm();
		msp.setGraphName(graphName);
		msp.setFirstEdgeLabel(firstEdgeLabel);
		msp.setSecondEdgeLabel(secondEdgeLabel);
		msp.setVertexId("4112");
		msp.setEdgeLabelFields("relation.name.eq('ben');age;name");
		msp.setDirection("relation.out;have.out");
		//
		final MappingScriptEntity mse = new MappingScriptEntity();
		mse.setGraphName(graphName);
		mse.setFirstEdgeLabel(firstEdgeLabel);
		mse.setSecondEdgeLabel(secondEdgeLabel);
		final String mappscript = "gremlin=g_@graphName.V(@vertexId).@firstDirE('@edgelabel1').@firstResultV().@edgefield1.@secondDirE('@edgelabel2').@secondResultV().@edgefield2.@field3";
		mse.setMappingScript(mappscript);
		mse.setVertexId(true);
		mse.setEdgeLabelFields(true);
		mse.setDirection(true);

		final MappingScriptParm msp1 = new MappingScriptParm();
		msp1.setGraphName(graphName);
		msp1.setFirstEdgeLabel(firstEdgeLabel);
		msp1.setSecondEdgeLabel(secondEdgeLabel);
		msp1.setVertexId("4112");

		final MappingScriptEntity mse1 = new MappingScriptEntity();
		mse1.setGraphName(graphName);
		mse1.setFirstEdgeLabel(firstEdgeLabel);
		mse1.setSecondEdgeLabel(secondEdgeLabel);
		mse1.setVertexId(true);
		final String mappingScript1 = "gremlin=g_@graphName.V(@vertexId).outE('@edgelabel1').inV().outE('@edgelabel2').inV()";
		mse1.setMappingScript(mappingScript1);

		final MappingScript test = new MappingScript();
		//		System.out.println("get");
		//		System.out.println("request url: graphapi/service/v1/testzh/4112/relation/have");
		//		System.out.println(msp1.toString());
		//		System.out.println("gremlin result \n" + test.testFields(msp1, mse1));

		System.out.println("get");
		System.out.println("GraphApi MappingRequest: /{graphName}/{vertexId}/{edgelabelOne}/{edgeLabelTwo}");
		System.out.println("url: graphapi/service/v1/testzh/4112/relation/have");
		System.out.println("validate the requst to graphconsole");
		System.out.println("request url: graphapi/service/v1/testzh/4112/relation/have?deirection=relation.out;have.out&edgeLabelFields=relation.name.eq('ben');age");
		System.out.println("gremlin result \n" + test.testFields(msp, mse));
	}
}
