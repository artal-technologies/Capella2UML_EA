/**
 * 
 */
package org.eclipse.capella.mapping.capella2uml.bridge;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.artal.capella.mapping.mix.AbstractMappingAlgoMix;
import com.artal.capella.mapping.uml.UMLBridgeJob;

/**
 * @author binot
 *
 */
public class Capella2UMLBridgeJob extends UMLBridgeJob<Project> {

	public Capella2UMLBridgeJob(String jobName_p, Project sourceDataSet_p, URI targetURI_p,
			AbstractMappingAlgoMix<?, ?> mix) {
		super(sourceDataSet_p, targetURI_p, new Capella2UMLAlgo(mix));
	}

	public void setTargetParentFolder(String folder) {

	}

	@Override
	protected Resource getCreateTraceResource(URI uri_p) {
		return super.getCreateTargetResource(uri_p);
	}

	/**
	 * @param saveOptions
	 */
	public void addOptions(final Map<Object, Object> saveOptions) {
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		saveOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);

		final ExtendedMetaData ext = new BasicExtendedMetaData(ExtendedMetaData.ANNOTATION_URI,
				EPackage.Registry.INSTANCE, new HashMap<>());
		ext.setQualified(UMLPackage.eINSTANCE, true);
		ext.setFeatureKind(UMLPackage.eINSTANCE.getTypedElement_Type(), ExtendedMetaData.ELEMENT_FEATURE);
		saveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, ext);
	}

	/**
	 * @return
	 */
	public String getXMIVersion() {
		return XMIResource.VERSION_2_1_VALUE;
	}

	protected XMLHelper createOwnedXMLHelper(XMIResource resource) {
		return new XMIHelperImpl(resource) {

		};
	}

	@Override
	public XMLSave createOwnXMLSave(XMLHelper xmlHelper) {
		// TODO Auto-generated method stub
		return new XMISaveImpl(xmlHelper) {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl#saveElementReferenceSingle(org.
			 * eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
			 */
			@Override
			protected void saveElementReferenceSingle(EObject o, EStructuralFeature f) {
				// TODO Auto-generated method stub

				if (o instanceof Property || o instanceof Parameter) {
					if (f.getName().equals("type")) {
						// super.saveElementReferenceSingle(o, f);

						EObject remote = (EObject) helper.getValue(o, f);
						if (remote != null) {
							String href = helper.getHREF(remote);
							if (href != null) {
								href = convertURI(href);
								EClass eClass = remote.eClass();
								EClass expectedType = (EClass) f.getEType();
								boolean shouldSaveType = saveTypeInfo
										? xmlTypeInfo.shouldSaveType(eClass, expectedType, f)
										: eClass != expectedType && (expectedType.isAbstract()
												|| f.getEGenericType().getETypeParameter() != null);
								if (elementHandler != null && shouldSaveType) {
									EStructuralFeature substitutionGroup = featureTable.getSubstitutionGroup(f, eClass);
									if (substitutionGroup != null) {
										f = substitutionGroup;
										shouldSaveType = substitutionGroup.getEType() != eClass;
									}
								}
								if (!toDOM) {
									doc.startElement(helper.getQName(f));
								} else {
									helper.populateNameInfo(nameInfo, f);
									Element elem = document.createElementNS(nameInfo.getNamespaceURI(),
											nameInfo.getQualifiedName());
									Node text = document.createTextNode(href);
									elem.appendChild(text);
									currentNode = currentNode.appendChild(elem);
									handler.recordValues(elem, remote.eContainer(), f, remote);
									handler.recordValues(text, remote.eContainer(), f, remote);
								}
								if (shouldSaveType) {
									saveTypeAttribute(eClass);

								}
								if (!toDOM) {
									// doc.add(" xmi:idref=\"" + href.replace("#", "") + "\"");
									doc.addAttribute("xmi:idref", href.replace("#", ""));
									doc.endContentElement("");
								} else {
									currentNode = currentNode.getParentNode();
								}
							}
						}

						// String href = xmlHelper.getHREF(o);
						// doc.add(">");
						// doc.addLine();
						// doc.add("<type xmi:idref=" + href + "/>");
						// doc.addLine();
						// doc.add("</ownedAttribute>");
					}
				} else {

					super.saveElementReferenceSingle(o, f);
				}
			}
		};

	}

	/**
	 * @return
	 */
	public String getEncoding() {
		return "windows-1252";
	}

}
