<<<<<<<< HEAD:frontend/target/dev-bundle/webapp/VAADIN/build/copilot-features-plugin-JNRru65U-eND383FK.js
import{N as d,a as u,B as g,A as f}from"./indexhtml-wbxNgqLu.js";import{o as p}from"./base-panel-Zq4jKPA_-pbIi4HQD.js";var h=Object.defineProperty,b=Object.getOwnPropertyDescriptor,c=(e,t,a,s)=>{for(var r=s>1?void 0:s?b(t,a):t,n=e.length-1,o;n>=0;n--)(o=e[n])&&(r=(s?o(t,a,r):o(r))||r);return s&&r&&h(t,a,r),r};const l=window.Vaadin.devTools;let i=class extends p{constructor(){super(),this.handleFeatureFlags=e=>{this.features=e.data.features},this.features=[]}connectedCallback(){super.connectedCallback(),this.onCommand("featureFlags",this.handleFeatureFlags)}render(){return d` <div class="features-tray">
========
import{N as d,a as u,B as g,A as f}from"./indexhtml-GE3HoQKM.js";import{o as p}from"./base-panel-Zq4jKPA_-5ufs4OBh.js";var h=Object.defineProperty,b=Object.getOwnPropertyDescriptor,c=(e,t,a,s)=>{for(var r=s>1?void 0:s?b(t,a):t,n=e.length-1,o;n>=0;n--)(o=e[n])&&(r=(s?o(t,a,r):o(r))||r);return s&&r&&h(t,a,r),r};const l=window.Vaadin.devTools;let i=class extends p{constructor(){super(),this.handleFeatureFlags=e=>{this.features=e.data.features},this.features=[]}connectedCallback(){super.connectedCallback(),this.onCommand("featureFlags",this.handleFeatureFlags)}render(){return d` <div class="features-tray">
>>>>>>>> frontend-Emma:frontend/target/dev-bundle/webapp/VAADIN/build/copilot-features-plugin-JNRru65U-UHxBSveQ.js
      ${this.features.map(e=>d` <div class="feature">
            <label class="switch">
              <input
                class="feature-toggle"
                id="feature-toggle-${e.id}"
                type="checkbox"
                ?checked=${e.enabled}
                @change=${t=>this.toggleFeatureFlag(t,e)} />
              <span class="slider"></span>
              ${e.title}
            </label>
            <a class="ahreflike" href="${e.moreInfoLink}" target="_blank">Learn more</a>
          </div>`)}
    </div>`}toggleFeatureFlag(e,t){const a=e.target.checked;l.frontendConnection?(l.frontendConnection.send("setFeature",{featureId:t.id,enabled:a}),l.showNotification(u.INFORMATION,`“${t.title}” ${a?"enabled":"disabled"}`,t.requiresServerRestart?"This feature requires a server restart":void 0,void 0,`feature${t.id}${a?"Enabled":"Disabled"}`)):l.log("error",`Unable to toggle feature ${t.title}: No server connection available`)}};c([g()],i.prototype,"features",2);i=c([f("copilot-features-panel")],i);const v={header:"Features",expanded:!0,draggable:!0,panelOrder:0,panel:"right",floating:!1,tag:"copilot-features-panel"},F={init(e){e.addPanel(v)}};window.Vaadin.copilotPlugins.push(F);export{i as CopilotFeaturesPanel};
